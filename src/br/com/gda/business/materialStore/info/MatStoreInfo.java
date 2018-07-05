package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class MatStoreInfo implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codMat;
	public String codLanguage;
	public String recordMode;
	
	
	
	public MatStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
		codLanguage = Language.getDefaultLanguage();
		recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public OwnerInfo toOwnerInfo() {
		OwnerInfo owner = new OwnerInfo();
		owner.codOwner = codOwner;
		return owner;
	}
	
	
	
	public StoreInfo toStoreInfo() {
		StoreInfo store = new StoreInfo();
		store.codOwner = codOwner;
		store.codStore = codStore;	
		store.codLanguage = codLanguage;
		return store;
	}
	
	
	
	public MatInfo toMatInfo() {
		MatInfo mat = new MatInfo();
		mat.codOwner = codOwner;
		mat.codMat = codMat;
		mat.codLanguage = codLanguage;
		return mat;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
