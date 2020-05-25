package br.com.mind5.business.scheduleDayData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.action.LazySchedaytaRootSelect;
import br.com.mind5.business.scheduleDayData.model.action.StdSchedaytaMergeSchedarch;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckLangu;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckOwner;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckSearch;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedaytaSearch extends DeciTreeTemplateWriteV2<SchedaytaInfo> {
	
	public RootSchedaytaSearch(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedaytaInfo> buildCheckerHook(DeciTreeOption<SchedaytaInfo> option) {
		List<ModelCheckerV1<SchedaytaInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedaytaInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedaytaCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedaytaInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedaytaInfo> option) {
		List<ActionStdV1<SchedaytaInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedaytaInfo> mergeSchedarch = new StdSchedaytaMergeSchedarch(option);
		ActionLazyV1<SchedaytaInfo> select = new LazySchedaytaRootSelect(option.conn, option.schemaName);
		
		mergeSchedarch.addPostAction(select);
		
		actions.add(mergeSchedarch);
		return actions;
	}
}
