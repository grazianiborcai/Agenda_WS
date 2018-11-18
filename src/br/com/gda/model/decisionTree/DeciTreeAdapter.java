package br.com.gda.model.decisionTree;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		if (tree == null) {
			logException(new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionListHook() throws SQLException {
		DeciResult<T> treeResult = makeDecision(deciTree);
		return getResults(treeResult); 
	}
	
	
	
	private DeciResult<T> makeDecision(DeciTree<T> tree) {
		tree.makeDecision();
		return tree.getDecisionResult();
	}
	
	
	
	private List<T> getResults(DeciResult<T> treeResult) {
		if (treeResult.hasResultset()) 
			return treeResult.getResultset();		  
	  
		return Collections.emptyList();	
	}
	
	
	
	@Override protected DeciResult<T> buildResultFailedHook() {
		return deciTree.getDecisionResult();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
