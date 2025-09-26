package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import com.devsuperior.dslist.services.exceptions.ResourceNotFoundException;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
	    gameListRepository.findById(listId)
	        .orElseThrow(() -> new ResourceNotFoundException("Lista não encontrada: " + listId));

	    List<GameMinProjection> list = gameRepository.searchByList(listId);

	    if (sourceIndex < 0 || sourceIndex >= list.size() ||
	        destinationIndex < 0 || destinationIndex >= list.size()) {
	        throw new IllegalArgumentException("Índices inválidos para movimentação");
	    }

	    GameMinProjection obj = list.remove(sourceIndex);
	    list.add(destinationIndex, obj);

	    int min = Math.min(sourceIndex, destinationIndex);
	    int max = Math.max(sourceIndex, destinationIndex);

	    for (int i = min; i <= max; i++) {
	        gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
	    }
	}

	
}