package br.com.mind5.message.email.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailSetterScheduleConfirmation;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmailVisiEnforceScheduleConfirmation extends ActionVisitorTemplateEnforce<EmailInfo> {
	
	public EmailVisiEnforceScheduleConfirmation(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterScheduleConfirmation();
		return attrSetter.setAttr(recordInfo);
	}
}
