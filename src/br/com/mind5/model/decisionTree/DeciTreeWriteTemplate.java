package br.com.mind5.model.decisionTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;

public abstract class DeciTreeWriteTemplate<T extends InfoRecord> implements DeciTree<T> {
	private DeciTree<T> currentTree;
	private List<DeciTree<T>> trees;
	private Iterator<DeciTree<T>> itr;
	
	
	public DeciTreeWriteTemplate(DeciTreeOption<T> option) {
		checkArgument(option);
		trees = buildTrees(option);
		
		itr = trees.iterator();
		currentTree = itr.next();
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
	
	
	
	private List<DeciTree<T>> buildTrees(DeciTreeOption<T> option) {
		List<DeciTree<T>> resultTrees = new ArrayList<>();
		
		for (T eachRecord : option.recordInfos) {
			DeciTreeOption<T> flatOption = flattenTreeOption(option, eachRecord);
			DeciTreeHelper<T> treeHelper = buildTreeHelper(flatOption);
			resultTrees.add(treeHelper);
		}
		
		return resultTrees;
	}
	
	
	
	private DeciTreeOption<T> flattenTreeOption(DeciTreeOption<T> option, T recordInfo) {
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
		
		helperOption.visitorChecker = buildDecisionCheckerHook(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassedHook(option);
		helperOption.actionsOnFailed = buildActionsOnFailedHook(option);
		
		return new DeciTreeHelper<>(helperOption);
	}
	
	
	
	protected ModelChecker<T> buildDecisionCheckerHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	protected List<ActionStdV1<T>> buildActionsOnPassedHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	protected List<ActionStdV1<T>> buildActionsOnFailedHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		return null;	
	}
	
	
	
	@Override public void makeDecision() {
		currentTree.makeDecision();
		
		while(itr.hasNext()) {
			if (currentTree.getDecisionResult().isSuccess() == false)
				break;
			
			currentTree = itr.next();
			currentTree.makeDecision();
		}
	}
		

	/*
	@Override public DeciChoice getDecisionMade() {
		return currentTree.getDecisionMade();
	} */
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return makeDeciResult();
	}
	
	
	
	private DeciResult<T> makeDeciResult() {
		if (currentTree.getDecisionResult().isSuccess() == false)
			return currentTree.getDecisionResult();
		
		DeciResultHelper<T> result = new DeciResultHelper<>();
		result.copyWithoutResultset(currentTree.getDecisionResult());
		result.resultset = new ArrayList<>();
		
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
	
	
	
	@Override public ActionStdV1<T> toAction() {
		return new DeciTreeAdapter<>(trees);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
