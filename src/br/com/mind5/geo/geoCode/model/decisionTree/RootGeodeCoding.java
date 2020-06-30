package br.com.mind5.geo.geoCode.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.model.action.LazyGeodeCoding;
import br.com.mind5.geo.geoCode.model.action.LazyGeodeEnforceLocation;
import br.com.mind5.geo.geoCode.model.action.LazyGeodeMergeCountry;
import br.com.mind5.geo.geoCode.model.action.StdGeodeMergeState;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckCoding;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckCountry;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckLangu;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckOwner;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckState;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootGeodeCoding extends DeciTreeTemplateWriteV2<GeodeInfo> {
	
	public RootGeodeCoding(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<GeodeInfo> buildCheckerHook(DeciTreeOption<GeodeInfo> option) {
		List<ModelCheckerV1<GeodeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<GeodeInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GeodeCheckCoding(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new GeodeCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new GeodeCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new GeodeCheckCountry(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new GeodeCheckState(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<GeodeInfo>> buildActionsOnPassedHook(DeciTreeOption<GeodeInfo> option) {
		List<ActionStdV1<GeodeInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<GeodeInfo> mergeState = new StdGeodeMergeState(option);		
		ActionLazyV1<GeodeInfo> mergeCountry = new LazyGeodeMergeCountry(option.conn, option.schemaName);
		ActionLazyV1<GeodeInfo> enforceLocation = new LazyGeodeEnforceLocation(option.conn, option.schemaName);
		ActionLazyV1<GeodeInfo> coding = new LazyGeodeCoding(option.conn, option.schemaName);	
		
		mergeState.addPostAction(mergeCountry);
		mergeCountry.addPostAction(enforceLocation);
		enforceLocation.addPostAction(coding);
		
		actions.add(mergeState);		
		return actions;
	}
}
