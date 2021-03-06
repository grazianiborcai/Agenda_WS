package br.com.mind5.model.decisionTree;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;

public abstract class DeciTreeTemplateRead<T extends InfoRecord> implements DeciTree<T> {
	private DeciTree<T> tree;
	
	
	public DeciTreeTemplateRead(DeciTreeOption<T> option) {
		checkArgument(option);
		clear();
		
		DeciTreeHelperOption<T> helperOption = makeHelperOption(option);		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private DeciTreeHelperOption<T> makeHelperOption(DeciTreeOption<T> option) {
		DeciTreeHelperOption<T> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildCheckerHook(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassedHook(option);
		helperOption.actionsOnFailed = buildActionsOnFailedHook(option);
		
		return helperOption;
	}
	
	
	
	protected ModelChecker<T> buildCheckerHook(DeciTreeOption<T> option) {
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
		checkState();		
		tree.makeDecision();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		checkState();	
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		checkState();	
		return tree.toAction();
	}
	
	
	
	@Override public void close() {
		closeTree(tree);
		clear();
	}
	
	
	
	private void closeTree(DeciTree<T> deciTree) {
		if (deciTree == null)
			return;
		
		deciTree.close();		
	}
	
	
	
	private void clear() {
		tree = null;
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("options" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
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
	
	
	
	private void checkState() {
		if (tree == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
