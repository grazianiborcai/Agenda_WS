package br.com.mind5.business.bankAccount.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class BankaccCopier {
	public static List<BankaccInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<BankaccInfo, StoreInfo> copier = new BankaccCopyStore();
		return copier.makeCopy(sources);
	}
}
