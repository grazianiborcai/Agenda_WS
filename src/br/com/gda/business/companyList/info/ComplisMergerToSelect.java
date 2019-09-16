package br.com.gda.business.companyList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class ComplisMergerToSelect extends InfoMergerTemplate<ComplisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor<ComplisInfo, ComplisInfo> getVisitorHook() {
		return new ComplisVisiMergeToSelect();
	}
}
