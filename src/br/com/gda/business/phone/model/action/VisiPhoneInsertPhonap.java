package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhonapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiPhoneInsertPhonap extends ActionVisitorTemplateAction<PhoneInfo, PhonapInfo> {

	public VisiPhoneInsertPhonap(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonapInfo> getActionHook(DeciTreeOption<PhonapInfo> option) {
		return new RootPhonapInsert(option).toAction();
	}
	
	
	
	protected List<PhoneInfo> toBaseClassHook(List<PhoneInfo> baseInfos, List<PhonapInfo> results) {
		return PhoneMerger.mergeWithPhonap(results, baseInfos);
	}
}
