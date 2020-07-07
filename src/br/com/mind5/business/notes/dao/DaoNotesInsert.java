package br.com.mind5.business.notes.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoNotesInsert implements DaoStmtExecV2<NotesInfo> {
	private DaoStmtExecV2<NotesInfo> helper;
	
	
	public DaoNotesInsert(List<DaoStmtExecOption<NotesInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoNotesInsertSingle.class, NotesInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<NotesInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
