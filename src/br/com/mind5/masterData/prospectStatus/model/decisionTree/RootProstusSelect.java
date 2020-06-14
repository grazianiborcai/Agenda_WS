package br.com.mind5.masterData.prospectStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.action.StdProstusDaoSelect;
import br.com.mind5.masterData.prospectStatus.model.checker.ProstusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootProstusSelect extends DeciTreeTemplateWriteV2<ProstusInfo> {
	
	public RootProstusSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<ProstusInfo> buildCheckerHook(DeciTreeOption<ProstusInfo> option) {
		List<ModelCheckerV1<ProstusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<ProstusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ProstusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<ProstusInfo>> buildActionsOnPassedHook(DeciTreeOption<ProstusInfo> option) {
		List<ActionStdV1<ProstusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ProstusInfo> select = new StdProstusDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
