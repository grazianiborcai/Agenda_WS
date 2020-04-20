package br.com.mind5.masterData.country.info;


import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoCopier;

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
