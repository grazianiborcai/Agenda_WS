package br.com.mind5.geo.geoCode.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyGeodeCoding extends ActionLazyTemplate<GeodeInfo, GeodeInfo> {

	public LazyGeodeCoding(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<GeodeInfo> translateRecordInfosHook(List<GeodeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<GeodeInfo> getInstanceOfActionHook(DeciTreeOption<GeodeInfo> option) {
		return new StdGeodeCoding(option);
	}
	
	
	
	@Override protected DeciResult<GeodeInfo> translateResultHook(DeciResult<GeodeInfo> result) {
		return result;
	}
}
