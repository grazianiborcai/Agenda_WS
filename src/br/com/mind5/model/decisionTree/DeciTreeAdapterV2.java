package br.com.mind5.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public final class DeciTreeAdapterV2<T extends InfoRecord> implements ActionStdV2<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;	
	
	private List<DeciTree<T>> trees;
	private List<ActionLazy<T>> postActions;
	private DeciResult<T> finalResult;
	
	
	public DeciTreeAdapterV2(DeciTree<T> sourceTree) {
		checkArgument(sourceTree);		
		trees = toList(sourceTree);
	}
	
	
	
	public DeciTreeAdapterV2(List<DeciTree<T>> sourceTrees) {
		checkArgument(sourceTrees);		
		trees = sourceTrees;
	}
	
	
	
	@Override public boolean executeAction() {
		checkState(trees);	
		
		finalResult = executeTrees(trees);	
		finalResult = executePostActions(postActions, finalResult);
		
		return finalResult.isSuccess();
	}
	
	
	
	private DeciResult<T> executeTrees(List<DeciTree<T>> sourceTrees) {
		DeciResult<T> lastResult = makeErrorResult();
		
		
		for (DeciTree<T> eachTree : sourceTrees) {
			eachTree.makeDecision();
			lastResult = eachTree.getDecisionResult();
			
			if (lastResult.isSuccess() == false)
				return lastResult;
		}		
		
		return makeDeciResult(lastResult, sourceTrees);
	}
	
	
	
	private DeciResult<T> makeDeciResult(DeciResult<T> lastResult, List<DeciTree<T>> deciTrees) {
		if (lastResult == null)
			return makeErrorResult();
		
		if (lastResult.isSuccess() == false)
			return lastResult;
		
		List<T> allResultset = mergeResultset(deciTrees);
		return makeSuccessResult(allResultset);
	}
	
	
	
	private List<T> mergeResultset(List<DeciTree<T>> deciTrees) {	
		List<T> results = new ArrayList<>();
		
		for(DeciTree<T> eachTree : deciTrees) {
			DeciResult<T> eachResult = eachTree.getDecisionResult();
			
			if (eachResult.hasResultset() == true)
				results.addAll(eachResult.getResultset());
		}

		return results;
	}
	
	
	
	private DeciResult<T> executePostActions(List<ActionLazy<T>> actions, DeciResult<T> baseResult) {	
		if (shouldExecute(actions, baseResult) == FAILED)
			return baseResult;
		
		DeciResult<T> postResult = baseResult;	
		
		 
		for (ActionLazy<T> eachAction : actions) {
			List<T> baseInfos = makeClone(baseResult.getResultset());
			postResult = tryToExecutePostActions(eachAction, baseInfos);
			
			if (postResult.isSuccess() == FAILED)
				return postResult;
		}
				
		return postResult;
	}
	
	
	
	private DeciResult<T> tryToExecutePostActions(ActionLazy<T> postAction, List<T> baseInfos) {				
		try {
			postAction.executeAction(baseInfos);
			return postAction.getDecisionResult();
		
		} catch (Exception e) {
			logException(e);			
			return new DeciResultError<>();
		}		
	}	
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkState(finalResult);
		return makeClone(finalResult);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionLazy) {
		checkArgument(actionLazy);
		
		if (postActions == null)
			postActions = new ArrayList<>();
		
		postActions.add(actionLazy);	//TODO: defensive copy
	}
	
	
	
	
	@Override public void close() {
		closeTrees(trees);
		closeActions(postActions);
		clear();
	}
	
	
	
	private void closeTrees(List<DeciTree<T>> sourceTrees) {
		if (sourceTrees == null)
			return;
		
		if (sourceTrees.isEmpty())
			return;
		
		for (DeciTree<T> eachTree: sourceTrees) {
			closeTree(eachTree);
		}	
	}
	
	
	
	private void closeTree(DeciTree<T> sourceTree) {
		if (sourceTree == null)
			return;
		
		sourceTree.close();
	}
	
	
	
	private void closeActions(List<ActionLazy<T>> actions) {
		if (actions == null)
			return;
		
		if (actions.isEmpty())
			return;
		
		for (ActionLazy<T> eachAction : actions)
			closeAction(eachAction);
	}
	
	
	
	private void closeAction(ActionLazy<T> action) {
		if (action instanceof ActionLazy) {
			((ActionLazy<T>) action).close();
		}
	}
	
	
	
	private void clear() {
		trees = DefaultValue.object();
		finalResult = DefaultValue.object();
		postActions = DefaultValue.object();
	}
	
	
	
	private List<DeciTree<T>> toList(DeciTree<T> sourceTree) {
		List<DeciTree<T>> results = new ArrayList<>();
		results.add(sourceTree);
		return results;
	}
	
	
	private DeciResult<T> makeErrorResult() {
		return new DeciResultError<T>();
	}
	
	
	
	private DeciResult<T> makeSuccessResult(List<T> resultset) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = true;
		result.hasResultset = true;
		
		if(resultset == null)
			result.hasResultset = false;
		
		if(resultset.isEmpty())
			result.hasResultset = false;
		
		if (result.hasResultset == true)
			result.resultset = resultset;
		
		return result;
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private DeciResult<T> makeClone(DeciResult<T> source) {
		DeciResultHelper<T> copyResult = new DeciResultHelper<>();
		copyResult.copyFrom(source);
		
		return copyResult;
	}
	
	
	
	private boolean shouldExecute(List<ActionLazy<T>> actions, DeciResult<T> baseResult) {
		if (hasPostAction(actions) == FAILED)
			return FAILED;
		 
		if (baseResult.isSuccess() == FAILED)
			return FAILED;
		 
		if (baseResult.hasResultset() == FAILED)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private boolean hasPostAction(List<ActionLazy<T>> actions) {
		if (actions == null)
			return FAILED;
		
		if (actions.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private void checkState(List<DeciTree<T>> sourceTree) {
		if (sourceTree == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
		
		
		if (sourceTree.isEmpty()) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkState(DeciResult<T> finalResult) {
		if (hasFinalResult(finalResult) == false) {
			logException(new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED));
			throw new IllegalStateException(SystemMessage.ACTION_NOT_EXECUTED);
		}
	}
	
	
	
	private boolean hasFinalResult (DeciResult<T> finalResult) {
		if (finalResult == null)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private void checkArgument(DeciTree<T> sourceTree) {
		if (sourceTree == null) {
			logException(new NullPointerException("sourceTree" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceTree" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(List<DeciTree<T>> sourceTrees) {
		if (sourceTrees == null) {
			logException(new NullPointerException("sourceTrees" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sourceTrees" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sourceTrees.isEmpty()) {
			logException(new IllegalArgumentException("sourceTrees" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("sourceTrees" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(ActionLazy<T> actionHandler) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
