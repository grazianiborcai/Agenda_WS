package br.com.mind5.model.decisionTree;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;

public abstract class DeciTreeReadTemplate<T extends InfoRecord> implements DeciTree<T> {
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
		tree.makeDecision();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStdV1<T> toAction() {
		return tree.toAction();
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
