package br.com.mind5.model.decisionTree;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerV2;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public final class DeciTreeHelper<T extends InfoRecord> implements DeciTree<T> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	private final boolean EMPTY = false;
	
	private List<T> recordInfos;
	private ModelCheckerV1<T> checker;
	private DeciResult<T> deciResult;
	private List<ActionStdV1<T>> actionsOnPassed;
	private List<ActionStdV1<T>> actionsOnFailed;
	

	public DeciTreeHelper(DeciTreeHelperOption<T> option) {
		checkArgument(option);
		clear();
		init(option);
	}	
	
	
	
	@Override public void makeDecision() {
		boolean checkerResult = executeChecker(recordInfos, checker);
		
		if (checkerResult == SUCCESS)
			deciResult = onPassed(actionsOnPassed);
			
		if (checkerResult == FAILED)
			deciResult = onFailed(actionsOnFailed, checker);		
	}
	
	
	
	private boolean executeChecker(List<T> records, ModelCheckerV1<T> modelChecker) {	
		boolean lastResult = SUCCESS;
		
		for (T eachRecord : records) {
			lastResult = modelChecker.check(makeClone(eachRecord));			
			if (lastResult == FAILED) 
				break;
		}		
		
		return lastResult;
	}
	
	
		
	private DeciResult<T> onPassed(List<ActionStdV1<T>> actions) {
		if (hasAction(actions) == FAILED)
			return makeErrorResult();
		
		return executeActions(actions);
	}
	
	
	
	private DeciResult<T> onFailed(List<ActionStdV1<T>> actions, ModelCheckerV1<T> modelChecker) {
		if (hasAction(actions) == FAILED)		
			return makeCheckerResult(modelChecker);
		
		return executeActions(actions);		
	}
	
	
	
	private boolean hasAction(List<ActionStdV1<T>> decisionActions) {
		if (decisionActions == null)
			return FAILED;
		
		if (decisionActions.isEmpty())
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	private DeciResult<T> executeActions(List<ActionStdV1<T>> actions) {	
		DeciResult<T> lastResult = makeErrorResult();		
		
		if (hasAction(actions) == FAILED)
			return lastResult;		
		
		
		for (ActionStdV1<T> eachAction : actions) {
			eachAction.executeAction();
			lastResult = eachAction.getDecisionResult();		
			
			if (lastResult.isSuccess() == FAILED)
				break;
		}
		
		
		return lastResult;
	}


	
	@Override public DeciResult<T> getDecisionResult() {
		return makeClone(deciResult);
	}
	
	
	
	@Override public ActionStdV1<T> toAction() {
		return new DeciTreeAdapterV1<>(this);
	}
	
	
	
	@Override public void close() {
		closeActions(actionsOnPassed);
		closeActions(actionsOnFailed);
		closeChecker(checker);
		clear();
	}
	
	
	
	private void closeActions(List<ActionStdV1<T>> actions) {
		if (actions == null)
			return;
		
		if (actions.isEmpty())
			return;
		
		for(ActionStdV1<T> eachAction: actions) {
			if (eachAction instanceof ActionStdV2) {
				((ActionStdV2<T>) eachAction).close();
			}
		}
	}
	
	
	
	private void closeChecker(ModelCheckerV1<T> modelChecker) {
		if (modelChecker == null)
			return;
		
		if (modelChecker instanceof ModelCheckerV2)
			((ModelCheckerV2<T>) modelChecker).close();
	}
	
	
	
	private DeciResult<T> makeCheckerResult(ModelCheckerV1<T> modelChecker) {	
		if (modelChecker.getResult() == SUCCESS)
			return makeErrorResult();
		
		DeciResultHelper<T> result = new DeciResultHelper<>();		
		result.isSuccess = FAILED;
		result.hasResultset = EMPTY;
		result.failCode = modelChecker.getFailCode();
		result.failMessage = modelChecker.getFailMessage();
		
		return result;
	}
	
	
	
	private DeciResult<T> makeErrorResult() {
		return new DeciResultError<T>();
	}
	
	
	
	private T makeClone(T recordInfo) {
		return CloneUtil.cloneRecord(recordInfo, this.getClass());
	}
	
	
	
	private DeciResult<T> makeClone(DeciResult<T> source) {
		DeciResultHelper<T> result = new DeciResultHelper<>();		
		result.copyFrom(source);
		return result;
	}
	
	
	
	private void clear() {
		recordInfos = DefaultValue.list();
		checker = DefaultValue.object();
		deciResult = DefaultValue.object();
		actionsOnPassed = DefaultValue.list();
		actionsOnFailed = DefaultValue.list();
	}
	
	
	
	private void init(DeciTreeHelperOption<T> option) {	//TODO: defensive copy
		checker = option.visitorChecker;
		recordInfos = option.recordInfos;
		actionsOnPassed = option.actionsOnPassed;
		actionsOnFailed = option.actionsOnFailed;
		deciResult = null;
	}
	
	
	
	private void checkArgument(DeciTreeHelperOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("options" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.visitorChecker == null) {
			logException(new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.visitorChecker" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.actionsOnPassed == null) {
			logException(new NullPointerException("option.actionsOnPassed" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.actionsOnPassed" + SystemMessage.NULL_ARGUMENT);
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
