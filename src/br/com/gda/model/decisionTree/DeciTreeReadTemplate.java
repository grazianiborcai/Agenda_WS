package br.com.gda.model.decisionTree;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;

public abstract class DeciTreeReadTemplate<T> implements DeciTree<T> {
	private DeciTree<T> tree;
	
	
	public DeciTreeReadTemplate(DeciTreeOption<T> option) {
		DeciTreeHelperOption<T> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionCheckerHook(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassedHook(option);
		helperOption.actionsOnFailed = buildActionsOnFailedHook(option);
		
		tree = new DeciTreeHelper<>(helperOption);
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
		tree.makeDecision();
	}
		

/*	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	} */
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		return tree.toAction();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
