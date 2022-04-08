package br.com.mind5.business.notes.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class NotesDaoDelete implements DaoStmtExec<NotesInfo> {
	private DaoStmtExec<NotesInfo> helper;
	
	
	public NotesDaoDelete(List<DaoStmtExecOption<NotesInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, NotesDaoDeleteSingle.class, NotesInfo.class);
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
