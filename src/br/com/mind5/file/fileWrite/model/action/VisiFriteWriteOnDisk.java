package br.com.mind5.file.fileWrite.model.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFriteWriteOnDisk extends ActionVisitorTemplateSimple<FriteInfo> {
	
	public VisiFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	

	
	@Override public List<FriteInfo> executeTransformationHook(List<FriteInfo> recordInfos) {
		for(FriteInfo eachRecord: recordInfos) {
			FriteInfo result = tryToWriteOnDisk(eachRecord);
			
			if (result == null)
				return null;
		}
		
		
		return recordInfos;
	}
	
	
	
	private FriteInfo tryToWriteOnDisk(FriteInfo recordInfo) {
		try {
			writeOnDisk(recordInfo);
			return recordInfo;
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private void writeOnDisk(FriteInfo recordInfo) throws IOException {
		File file = new File(recordInfo.fileUri);		
		OutputStream out = new FileOutputStream(file); 
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		while ((read = recordInfo.fileData.read(bytes)) != -1) {
	         out.write(bytes, 0, read);
	      }
		
		out.flush();
	    out.close();
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.FILE_WRITE_ERROR;
	}
}
