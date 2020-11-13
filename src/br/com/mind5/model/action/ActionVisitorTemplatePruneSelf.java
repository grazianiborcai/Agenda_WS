package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionVisitorTemplatePruneSelf<T extends InfoRecord> implements ActionVisitor<T> {	
	private List<T> bases;
	
	public ActionVisitorTemplatePruneSelf(DeciTreeOption<T> option) {
		checkArgument(option);		
		bases = makeClone(option.recordInfos);
	}
		
	
	
	@Override public DeciResult<T> executeTransformation() {
		checkState();
			
		List<T> results = pruneHook(bases);		
		return makeResult(results);
	}
	
	
	
	protected List<T> pruneHook(List<T> recordInfos) {	
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> makeResult(List<T> results) {
		if (results == null)
			return makeResultNotFound();		
		
		if (results.isEmpty())
			return makeResultNotFound();
		
		return makeResultSuccess(results);
	}
	
	
	
	private DeciResult<T> makeResultNotFound() {
		return new DeciResultNotFound<>();
	}
	
	
	
	private DeciResult<T> makeResultSuccess(List<T> results) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = true;
		result.hasResultset = true;
		result.resultset = results;
		
		return result;
	}
	
	
	
	@Override public void close() {
		clear();
	}
	
	
	
	private void clear() {
		bases = DefaultValue.list();
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkState() {
		if (bases == null) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos.isEmpty()) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
	}

	
		
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
