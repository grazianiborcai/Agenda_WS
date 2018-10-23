package br.com.gda.model.decisionTree;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStdTemplate;

public final class DeciTreeAdapter<T> extends ActionStdTemplate<T> {
	private DeciTree<T> deciTree;
	
	public DeciTreeAdapter(DeciTree<T> tree) {
		super();
		checkArgument(tree);
		
		deciTree = tree;
	}
	
	
	
	private void checkArgument(DeciTree<T> tree) {
		if (tree == null)
			throw new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override protected List<T> tryToExecuteActionListHook() throws SQLException {
		  deciTree.makeDecision();
		  DeciResult<T> treeResult = deciTree.getDecisionResult();
		  
		  if (treeResult.hasResultset()) 
			  return treeResult.getResultset();		  
		  
		  return Collections.emptyList();		  
	}
	
	
	
	@Override protected DeciResult<T> buildResultFailedHook() {
		return deciTree.getDecisionResult();
	}
}
