package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersonapMergerGender extends InfoMergerTemplate_<PersonapInfo, GenderInfo> {

	@Override protected InfoMergerVisitor_<PersonapInfo, GenderInfo> getVisitorHook() {
		return new PersonapVisiMergeGender();
	}
}
