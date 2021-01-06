package br.com.mind5.file.fileRead.model.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFreadReadFromDisk extends ActionVisitorTemplateSimple<FreadInfo> {
	
	public VisiFreadReadFromDisk(DeciTreeOption<FreadInfo> option) {
		super(option);
	}
	

	
	@Override protected List<FreadInfo> executeTransformationHook(List<FreadInfo> recordInfos) {
		for(FreadInfo eachRecord: recordInfos) {
			FreadInfo result = tryToReadFromDisk(eachRecord);
			
			if (result == null)
				return null;
		}
		
		
		return recordInfos;
	}
	
	
	
	private FreadInfo tryToReadFromDisk(FreadInfo recordInfo) {
		try {
			readFromDisk(recordInfo);
			return recordInfo;
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void readFromDisk(FreadInfo recordInfo) throws IOException {
		File file = new File(recordInfo.fileUri);		
		recordInfo.fileData = new FileInputStream(file);
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.FILE_READ_ERROR;
	}
}
