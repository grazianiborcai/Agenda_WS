package br.com.mind5.business.storeTextSearch.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
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
	
	
	
	public static StorextarchInfo copyFromMatextsnap(MatextsnapInfo source) {
		InfoCopier<StorextarchInfo, MatextsnapInfo> copier = new StorextarchCopyMatextsnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextarchInfo> copyFromMatextsnap(List<MatextsnapInfo> sources) {
		InfoCopier<StorextarchInfo, MatextsnapInfo> copier = new StorextarchCopyMatextsnap();
		return copier.makeCopy(sources);
	}	
}
