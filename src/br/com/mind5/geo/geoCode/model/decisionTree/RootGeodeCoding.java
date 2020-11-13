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
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootGeodeCoding extends DeciTreeTemplateWrite<GeodeInfo> {
	
	public RootGeodeCoding(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GeodeInfo> buildCheckerHook(DeciTreeOption<GeodeInfo> option) {
		List<ModelChecker<GeodeInfo>> queue = new ArrayList<>();		
		ModelChecker<GeodeInfo> checker;	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GeodeInfo>> buildActionsOnPassedHook(DeciTreeOption<GeodeInfo> option) {
		List<ActionStd<GeodeInfo>> actions = new ArrayList<>();	
		
		ActionStd<GeodeInfo> mergeState = new StdGeodeMergeState(option);		
		ActionLazy<GeodeInfo> mergeCountry = new LazyGeodeMergeCountry(option.conn, option.schemaName);
		ActionLazy<GeodeInfo> enforceLocation = new LazyGeodeEnforceLocation(option.conn, option.schemaName);
		ActionLazy<GeodeInfo> coding = new LazyGeodeCoding(option.conn, option.schemaName);	
		
		mergeState.addPostAction(mergeCountry);
		mergeCountry.addPostAction(enforceLocation);
		enforceLocation.addPostAction(coding);
		
		actions.add(mergeState);		
		return actions;
	}
}
