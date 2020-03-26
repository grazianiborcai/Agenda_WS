package br.com.mind5.model.checker;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;


public final class ModelCheckerQueue<T> implements ModelChecker<T> {
	protected final boolean SUCCESS = true;
	protected final boolean FAILED = false;
	
	private final List<ModelChecker<T>> checkers;
	private ModelChecker<T> currentChecker;
	
	
	public ModelCheckerQueue(List<ModelChecker<T>> queue) {
		checkQueue(queue);
		checkers = queue;
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkArgument(recordInfos);
		
		for (T eachRecord : recordInfos) {
			boolean checkResult = check(eachRecord);
			if (checkResult == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}	
	
	
	
	@Override public boolean check(T recordInfo) {
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
		checkState(currentChecker);		
		return currentChecker.getResult();
	}
	
	
	
	@Override public String getFailMessage() {
		checkState(currentChecker);		
		return currentChecker.getFailMessage();
	}
	
	
	
	@Override public int getFailCode() {
		checkState(currentChecker);		
		return currentChecker.getFailCode();
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
	
	
	
	private void checkState(ModelChecker<T> checker) {
		if (checker == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
