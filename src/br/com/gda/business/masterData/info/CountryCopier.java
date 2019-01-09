package br.com.gda.business.masterData.info;


import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoCopier;

public final class CountryCopier {
	public static CountryInfo copyFromComp(CompInfo source) {
		InfoCopier<CountryInfo, CompInfo> copier = new CountryCopyComp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CountryInfo> copyFromComp(List<CompInfo> sources) {
		InfoCopier<CountryInfo, CompInfo> copier = new CountryCopyComp();
		return copier.makeCopy(sources);
	}
}
