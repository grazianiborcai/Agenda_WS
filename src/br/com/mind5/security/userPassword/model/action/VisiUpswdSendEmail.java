package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeCopier;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.RootEmacomeSend;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class VisiUpswdSendEmail extends ActionVisitorTemplateAction<UpswdInfo, EmacomeInfo> {
	public VisiUpswdSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName, UpswdInfo.class, EmacomeInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmacomeInfo> getActionHook(DeciTreeOption<EmacomeInfo> option) {
		return new RootEmacomeSend(option).toAction();
	}
	
	
	
	@Override protected List<EmacomeInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return EmacomeCopier.copyFromUpswd(recordInfos);
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmacomeInfo> results) {
		return baseInfos;
	}
}
