package br.com.mind5.model.checker;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;


public final class ModelCheckerHelperQueue<T extends InfoRecord> implements ModelChecker<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	
	private List<ModelChecker<T>> checkers;
	private ModelChecker<T> currentChecker;
	
	
	public ModelCheckerHelperQueue(List<ModelChecker<T>> queue) {
		checkQueue(queue);
		checkers = queue;
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkState();
		checkArgument(recordInfos);
		
		for (T eachRecord : recordInfos) {
			boolean checkResult = check(eachRecord);
			if (checkResult == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}	
	
	
	
	@Override public boolean check(T recordInfo) {
		checkState();
		checkArgument(recordInfo);
		boolean checkResult = SUCCESS;
		
		
		for (ModelChecker<T> eachChecker : checkers) {
			currentChecker = eachChecker;
			checkResult = eachChecker.check(recordInfo);
			
			if (checkResult == FAILED)
				break;
		}
		
		
		return checkResult;		
	}
	
	
	
	@Override public boolean getResult() {
		checkState();
		checkLastChecker(currentChecker);		
		return currentChecker.getResult();
	}
	
	
	
	@Override public String getFailMessage() {
		checkState();
		checkLastChecker(currentChecker);		
		return currentChecker.getFailMessage();
	}
	
	
	
	@Override public int getFailCode() {
		checkState();
		checkLastChecker(currentChecker);		
		return currentChecker.getFailCode();
	}
	
	
	
	@Override public void close() {
		closeQueue(checkers);
		clear();
	}
	
	
	
	private void closeQueue(List<ModelChecker<T>> queue) {
		if (queue == null)
			return;
		
		if (queue.isEmpty())
			return;
		
		for (ModelChecker<T> eachChecker : queue) {
			closeChecker(eachChecker);
		}
	}
	
	
	
	private void closeChecker(ModelChecker<T> checker) {
		if (checker == null)
			return;
		
		if (checker instanceof ModelChecker)
			((ModelChecker<T>) checker).close();
	}
	
	
	
	private void checkQueue(List<ModelChecker<T>> queue) {
		if (queue == null) {
			logException(new NullPointerException("queue" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("queue" + SystemMessage.NULL_ARGUMENT);
		}	
		
		
		if (queue.isEmpty()) {
			logException(new NullPointerException("queue" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("queue" + SystemMessage.EMPTY_ARGUMENT);
		}	
	}
	
	
	
	private void clear() {
		checkers = DefaultValue.list();
		currentChecker = DefaultValue.object();
	}
	
	
	
	private void checkState() {
		if (checkers == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkArgument(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo " + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo " + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkLastChecker(ModelChecker<T> checker) {
		if (checker == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
