package br.com.mind5.file.filePath.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.FilePath;

public final class FathSetterCodImage extends InfoSetterTemplate<FathInfo> {
	
	@Override protected FathInfo setAttrHook(FathInfo recordInfo) {
		recordInfo.codFilePath = FilePath.FILE_IMAGE.getCodPath();
		return recordInfo;
	}
}
