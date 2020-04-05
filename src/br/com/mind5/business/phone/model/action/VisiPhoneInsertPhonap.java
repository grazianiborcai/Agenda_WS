package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.RootPhonapInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneInsertPhonap extends ActionVisitorTemplateActionV1<PhoneInfo, PhonapInfo> {

	public VisiPhoneInsertPhonap(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PhonapInfo> getActionHook(DeciTreeOption<PhonapInfo> option) {
		return new RootPhonapInsert(option).toAction();
	}
	
	
	
	protected List<PhoneInfo> toBaseClassHook(List<PhoneInfo> baseInfos, List<PhonapInfo> results) {
		return PhoneMerger.mergeWithPhonap(results, baseInfos);
	}
}
