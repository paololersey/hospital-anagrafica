import { InserimentoModule } from './inserimento.module';

describe('InserimentoModule', () => {
  let inserimentoModule: InserimentoModule;

  beforeEach(() => {
    inserimentoModule = new InserimentoModule();
  });

  it('should create an instance', () => {
    expect(inserimentoModule).toBeTruthy();
  });
});
