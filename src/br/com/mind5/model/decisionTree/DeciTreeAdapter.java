package br.com.mind5.model.decisionTree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdTemplate;

public final class DeciTreeAdapter<T extends InfoRecord> extends ActionStdTemplate<T> {
	private DeciTree<T> currentTree;
	private List<DeciTree<T>> trees;
	private Iterator<DeciTree<T>> itr;
	
	
	public DeciTreeAdapter(DeciTree<T> tree) {
		super();
		checkArgument(tree);		

		trees = new ArrayList<>();
		trees.add(tree);
		
		itr = trees.iterator();
		currentTree = itr.next();
	}
	
	
	
	public DeciTreeAdapter(List<DeciTree<T>> trees) {
		super();
		checkArgument(trees);		

		this.trees = trees;
		
		itr = this.trees.iterator();
		currentTree = itr.next();
	}
	
	
	
	private void checkArgument(DeciTree<T> tree) {
		if (tree == null) {
			logException(new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("tree" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(List<DeciTree<T>> trees) {
		if (trees == null) {
			logException(new NullPointerException("trees" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("trees" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (trees.isEmpty()) {
			logException(new IllegalArgumentException("trees" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("trees" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		List<T> results = new ArrayList<>();		
		
		DeciResult<T> treeResult = makeDecision(currentTree);
		results = makeResultList(treeResult, results); 
		
		while(itr.hasNext()) {
			if (shouldBreak(treeResult))
				break;
			
			currentTree = itr.next();			
			treeResult = makeDecision(currentTree);
			results = makeResultList(treeResult, results); 
		}
		
		return results;
	}

		
	
	private DeciResult<T> makeDecision(DeciTree<T> tree) {
		tree.makeDecision();
		return tree.getDecisionResult();
	}	
	
	
	
	private List<T> makeResultList(DeciResult<T> treeResult, List<T> listResult) {
		if (treeResult.isSuccess() == false) 
			return makeResultListFailed(treeResult);
		
		if (treeResult.hasResultset())
			listResult.addAll(treeResult.getResultset());
		
		return listResult;
	}
	
	
	
	private List<T> makeResultListFailed(DeciResult<T> treeResult) {
		if (treeResult.hasResultset()) 
			return treeResult.getResultset();

		return Collections.emptyList();	
	}
	
	
	
	private boolean shouldBreak(DeciResult<T> treeResult) {
		return (treeResult.isSuccess() == false);
	}
	
	
	
	@Override protected DeciResult<T> buildResultFailedHook() {
		return makeDeciResult();
	}
	
	
	
	private DeciResult<T> makeDeciResult() {
		if (currentTree.getDecisionResult().isSuccess() == false)
			return currentTree.getDecisionResult();
		
		DeciResultHelper<T> result = new DeciResultHelper<>();
		result.copyWithoutResultset(currentTree.getDecisionResult());
		
		for (DeciTree<T> eachTree : trees) {		
			result = mergeResultset(eachTree.getDecisionResult(), result);
		}
		
		return result;
	}
	
	
	
	private DeciResultHelper<T> mergeResultset(DeciResult<T> source, DeciResultHelper<T> target) {
		if (source.hasResultset())
			target.resultset.addAll(source.getResultset());
		
		return target;
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
