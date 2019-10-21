package br.com.mind5.model;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.mind5.model.decisionTree.DeciResult;

public interface ModelResponse<T> {
	public void addTreeResults(List<DeciResult<T>> results);
	
	public void addTreeResult(DeciResult<T> result);
	
	public Response build();
}
