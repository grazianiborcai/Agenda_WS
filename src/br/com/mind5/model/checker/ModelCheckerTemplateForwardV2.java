package br.com.mind5.model.checker;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public class ModelCheckerTemplateForwardV2<T extends InfoRecord, S extends InfoRecord> implements ModelCheckerV2<T> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<S> helper;
	
	
	public ModelCheckerTemplateForwardV2(ModelCheckerOption option) {
		helper = getCheckerHook(option);
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkState();
		checkArgument(recordInfos);
		
		for (T eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(T recordInfo) {
		checkState();
		checkArgument(recordInfo);
		
		S translated = toForwardClass(recordInfo);
		return helper.check(translated);
	}

	
	
	@Override public boolean getResult() {
		checkState();
		return helper.getResult();
	}

	
	
	@Override public String getFailMessage() {
		checkState();
		return helper.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		checkState();
		return helper.getFailCode();
	}


	
	@Override public void close() {
		closeHelper(helper);
		clear();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void closeHelper(ModelCheckerV1<S> checker) {
		if (checker == null)
			return;
		
		if (checker instanceof ModelCheckerV2)		
			((ModelCheckerV2<T>) checker).close();
	}
	
	
	
	private void clear() {
		helper = DefaultValue.object();
	}
	
	
	
	protected ModelCheckerV1<S> getCheckerHook(ModelCheckerOption option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected S toForwardClass(T baseRecord) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkState() {
		if (helper == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkArgument(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	protected void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
