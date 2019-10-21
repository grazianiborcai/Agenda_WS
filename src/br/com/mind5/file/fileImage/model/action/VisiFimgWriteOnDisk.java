package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileWrite.info.FriteCopier;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.decisionTree.RootFriteWriteOnDisk;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgWriteOnDisk extends ActionVisitorTemplateAction<FimgInfo, FriteInfo> {
	public VisiFimgWriteOnDisk(Connection conn, String schemaName) {
		super(conn, schemaName, FimgInfo.class, FriteInfo.class);
	}
	
	
	
	@Override protected ActionStd<FriteInfo> getActionHook(DeciTreeOption<FriteInfo> option) {
		return new RootFriteWriteOnDisk(option).toAction();
	}
	
	
	
	@Override protected List<FriteInfo> toActionClassHook(List<FimgInfo> baseInfos) {
		return FriteCopier.copyFromFimg(baseInfos);
	}
	
	
	
	@Override protected List<FimgInfo> toBaseClassHook(List<FimgInfo> baseInfos, List<FriteInfo> results) {
		return baseInfos;
	}
}
