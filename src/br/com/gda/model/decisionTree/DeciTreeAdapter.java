package br.com.gda.model.decisionTree;

import br.com.gda.common.SystemMessage;

public final class DeciTreeAdapter<T> implements DeciAction<T> {
	private DeciTree<T> deciTree;
	
	public DeciTreeAdapter(DeciTree<T> tree) {
		checkArgument(tree);
		
		deciTree = tree;
	}
	
	
	
	private void checkArgument(DeciTree<T> tree) {
		if (tree == null)
			throw new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	

	@Override public boolean executeAction() {			
		  deciTree.makeDecision();
		  DeciResult<T> treeResult = deciTree.getDecisionResult();
		  return treeResult.hasSuccessfullyFinished();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return deciTree.getDecisionResult();
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<T> actionHandler) {
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);
	}
}
