package br.com.mind5.message.emailProspectStore.model.action;

import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmaproreSendEmail extends ActionStdTemplateV2<EmaproreInfo> {

	public StdEmaproreSendEmail(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmaproreInfo> buildVisitorHook(DeciTreeOption<EmaproreInfo> option) {
		return new VisiEmaproreSendEmail(option);
	}
}
