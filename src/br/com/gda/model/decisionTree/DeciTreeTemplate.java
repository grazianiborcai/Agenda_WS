package br.com.gda.model.decisionTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;

public abstract class DeciTreeTemplate<T> implements DeciTree<T> {
	private DeciTree<T> currentTree;
	private List<DeciTree<T>> trees;
	private Iterator<DeciTree<T>> itr;
	
	
	public DeciTreeTemplate(DeciTreeOption<T> option) {
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
	
	
	
	protected List<ActionStd<T>> buildActionsOnPassedHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	protected List<ActionStd<T>> buildActionsOnFailedHook(DeciTreeOption<T> option) {
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
		

	
	@Override public DeciChoice getDecisionMade() {
		return currentTree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return currentTree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		return currentTree.toAction();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
