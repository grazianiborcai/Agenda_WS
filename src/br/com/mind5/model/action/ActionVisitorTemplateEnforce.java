package br.com.mind5.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionVisitorTemplateEnforce<T extends InfoRecord> implements ActionVisitor<T> {
	protected final boolean UNIQUIFY_RESULTS = true;
	protected final boolean DONT_UNIQUIFY_RESULTS = false;
	
	private List<T> bases;
	

	public ActionVisitorTemplateEnforce(DeciTreeOption<T> option) {
		checkArgument(option);	
		clear();
		
		bases = getBaseInfos(option);	
	}
	
	
	
	private List<T> getBaseInfos(DeciTreeOption<T> option) {
		return makeClone(option.recordInfos);
	}
	
	
		
	@Override public DeciResult<T> executeTransformation() {
		List<T> enforcedInfos = enforce(bases);
		
		if (checkEnforceds(enforcedInfos) == false)
			return makeNotFoundResult();
		
		enforcedInfos = uniquify(enforcedInfos);
		return makeSuccessResult(enforcedInfos);
	}
	
	
	
	private List<T> enforce(List<T> baseInfos) {
		List<T> results = new ArrayList<>();		
		
		for (T eachBase : baseInfos) {
			T eachResult = enforceHook(eachBase);			
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	protected T enforceHook(T baseInfo) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private boolean checkEnforceds(List<T> resultInfos) {
		if (resultInfos == null)
			return false;
		
		if (resultInfos.isEmpty())
			return false;
		
		for (T eachResult : resultInfos) {
			if (eachResult == null)
				return false;
		}
		
		return true;
	}
	
	
	
	private List<T> uniquify(List<T> resultInfos) {
		if(shouldUniquifyResult() == false)
			return resultInfos;
		
		return resultInfos.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	protected boolean shouldUniquifyResult() {
		//Template method: default behavior
		return DONT_UNIQUIFY_RESULTS;
	}
	
	
	
	private DeciResult<T> makeSuccessResult(List<T> enforcedInfos) {
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.resultset = enforcedInfos;
		helper.isSuccess = true;
		helper.hasResultset = true;
		
		return helper;
	}
	
	
	
	private <K extends InfoRecord> DeciResult<K> makeNotFoundResult() {
		return new DeciResultNotFound<K>();
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
