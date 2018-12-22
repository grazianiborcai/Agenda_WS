package br.com.gda.business.materialSnapshot.model.action;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatSnapEnforceKey extends ActionVisitorTemplateEnforce<MatSnapInfo> {
	@Override protected MatSnapInfo enforceHook(MatSnapInfo recordInfo) {
		MatSnapInfo enforcedRecord = new MatSnapInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codSnapshot = recordInfo.codSnapshot;
		return enforcedRecord;
	}
}
