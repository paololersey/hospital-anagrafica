import { EliminaClienteModule } from './elimina-cliente.module';

describe('EliminaClienteModule', () => {
  let eliminaClienteModule: EliminaClienteModule;

  beforeEach(() => {
    eliminaClienteModule = new EliminaClienteModule();
  });

  it('should create an instance', () => {
    expect(eliminaClienteModule).toBeTruthy();
  });
});
