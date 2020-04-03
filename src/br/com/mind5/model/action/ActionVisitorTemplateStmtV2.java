package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;
import br.com.mind5.model.decisionTree.common.DeciResultNotFound;

public abstract class ActionVisitorTemplateStmtV2<T extends InfoRecord> implements ActionVisitorV2<T> {	
	private DaoStmtExecV2<T> stmtExec;
	

	public ActionVisitorTemplateStmtV2(DeciTreeOption<T> option) {
		checkArgument(option);
		
		List<DaoStmtExecOption<T>> stmtOptions = buildStmtOptions(option);
		stmtExec = buildStmtExec(stmtOptions);
	}	
	

		
	private List<DaoStmtExecOption<T>> buildStmtOptions(DeciTreeOption<T> option) {
		List<DaoStmtExecOption<T>> resultOptions = new ArrayList<>();		
		List<T> baseInfos = makeClone(option.recordInfos);
		
		for(T eachRecord : baseInfos) {
			DaoStmtExecOption<T> eachOption = new DaoStmtExecOption<>();
			
			eachOption.conn = option.conn;
			eachOption.recordInfo = eachRecord;
			eachOption.schemaName = option.schemaName;
			resultOptions.add(eachOption);
		}
		
		return resultOptions;
	}
	
	
	
	private DaoStmtExecV2<T> buildStmtExec(List<DaoStmtExecOption<T>> stmtOptions) {
		return buildStmtExecHook(stmtOptions);
	}
	
	
	
	protected DaoStmtExecV2<T> buildStmtExecHook(List<DaoStmtExecOption<T>> stmtOptions) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}

	
	
		
	@Override public DeciResult<T> executeTransformation() {
		try {
			stmtExec.executeStmt();
			List<T> resulset = stmtExec.getResultset();
			DeciResult<T> result = buildDeciResult(resulset);
			
			closeStmtExec(stmtExec);
			return result;
			
		} catch (SQLException e) {
			logException(e);
			closeStmtExec(stmtExec);
			return buildResultInternalError();
		}

	}
	
	
	
	private DeciResult<T> buildDeciResult(List<T> recordInfos) {
		if (recordInfos == null)
			return buildResultDataNotFound();
		
		if (recordInfos.isEmpty())
			return buildResultDataNotFound();
		
		return buildResultSuccess(recordInfos);
	}
	
	
	
	private DeciResult<T> buildResultDataNotFound() {
		return new DeciResultNotFound<>();
	}
	
	
	
	private DeciResult<T> buildResultSuccess(List<T> recordInfos) {
		DeciResultHelper<T> result = new DeciResultHelper<>();
		
		result.isSuccess = true;
		result.hasResultset = true;
		result.resultset =  makeClone(recordInfos);
		
		return result;
	}
	
	
	
	private DeciResult<T> buildResultInternalError() {
		return new DeciResultError<>();
	}
	
	
	
	@Override public void close() {
		closeStmtExec(stmtExec);
		clear();
	}
	
	
	
	private void closeStmtExec(DaoStmtExecV2<T> exec) {
		if (exec == null)
			return;
					
		exec.close();			
	}
	
	
	
	private void clear() {
		stmtExec = DefaultValue.object();
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
