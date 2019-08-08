package br.com.gda.business.personSnapshot.info;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class PersonapMergerGender extends InfoMergerTemplate<PersonapInfo, GenderInfo> {

	@Override protected InfoMergerVisitor<PersonapInfo, GenderInfo> getVisitorHook() {
		return new PersonapVisiMergeGender();
	}
}
