package br.com.mind5.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public abstract class DeciTreeTemplateWriteV1<T extends InfoRecord> implements DeciTree<T> {
	private List<DeciTree<T>> trees;
	private DeciResult<T> treeResult;
	
	
	public DeciTreeTemplateWriteV1(DeciTreeOption<T> option) {
		checkArgument(option);
		clear();
		
		trees = buildTrees(option);
	}
	
	
	
	private List<DeciTree<T>> buildTrees(DeciTreeOption<T> sourceOption) {
		List<DeciTree<T>> results = new ArrayList<>();
		
		for (T eachRecord : sourceOption.recordInfos) {
			T clonedRecord = makeClone(eachRecord);
			
			DeciTreeOption<T> treeOption = buildTreeOption(sourceOption, clonedRecord);
			DeciTreeHelper<T> treeHelper = buildTreeHelper(treeOption);
			results.add(treeHelper);
		}
		
		return results;
	}
	
	
	
	private DeciTreeOption<T> buildTreeOption(DeciTreeOption<T> option, T recordInfo) {
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);
		
		DeciTreeOption<T> result = new DeciTreeOption<>();
		result.recordInfos = recordInfos;
		result.conn = option.conn;
		result.schemaName = option.schemaName;
		
		return result;
	}
	
	
	
	private DeciTreeHelper<T> buildTreeHelper(DeciTreeOption<T> option) {
		DeciTreeHelperOption<T> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildCheckerHook(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassedHook(option);
		helperOption.actionsOnFailed = buildActionsOnFailedHook(option);
		
		return new DeciTreeHelper<>(helperOption);
	}
	
	
	
	protected ModelCheckerV1<T> buildCheckerHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	protected List<ActionStdV2<T>> buildActionsOnPassedHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	protected List<ActionStdV2<T>> buildActionsOnFailedHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		return null;	
	}
	
	
	
	@Override public void makeDecision() {
		checkState();
		
		for(DeciTree<T> eachTree : trees) {
			eachTree.makeDecision();
			treeResult = eachTree.getDecisionResult();
			
			if (treeResult.isSuccess() == false)
				break;
		}
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkState();
		return makeDeciResult(treeResult, trees);
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
	
	
	
	@Override public ActionStdV2<T> toAction() {
		checkState();
		return new DeciTreeAdapterV1<>(trees);
	}
	
	
	
	@Override public void close() {
		closeTree(trees);
		clear();
	}
	
	
	
	private void closeTree(List<DeciTree<T>> deciTrees) {
		if (deciTrees == null)
			return;
		
		if (deciTrees.isEmpty())
			return;
		
		for (DeciTree<T> eachTree: deciTrees) {
			eachTree.close();
		}
	}
	
	
	
	private void clear() {
		treeResult = DefaultValue.object();
		trees = DefaultValue.list();
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
	
	
	
	private void checkState() {
		if (trees == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private T makeClone(T recordInfo) {
		return CloneUtil.cloneRecord(recordInfo, this.getClass());
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("options" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}	
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
