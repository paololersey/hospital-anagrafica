import { ContainerServiceModule } from './container-service-module.module';

describe('ContainerServiceModuleModule', () => {
  let containerServiceModuleModule: ContainerServiceModule;

  beforeEach(() => {
    containerServiceModuleModule = new ContainerServiceModule();
  });

  it('should create an instance', () => {
    expect(containerServiceModuleModule).toBeTruthy();
  });
});
