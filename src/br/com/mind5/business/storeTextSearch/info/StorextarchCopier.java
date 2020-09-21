package br.com.mind5.business.storeTextSearch.info;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoCopier;

public final class StorextarchCopier {

	public static StorextarchInfo copyFromStorext(StorextInfo source) {
		InfoCopier<StorextarchInfo, StorextInfo> copier = new StorextarchCopyStorext();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextarchInfo> copyFromStorext(List<StorextInfo> sources) {
		InfoCopier<StorextarchInfo, StorextInfo> copier = new StorextarchCopyStorext();
		return copier.makeCopy(sources);
	}
}
