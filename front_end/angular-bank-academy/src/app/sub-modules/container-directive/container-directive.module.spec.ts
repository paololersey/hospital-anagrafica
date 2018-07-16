import { ContainerDirectiveModule } from './container-directive.module';

describe('ContainerDirectiveModule', () => {
  let containerDirectiveModule: ContainerDirectiveModule;

  beforeEach(() => {
    containerDirectiveModule = new ContainerDirectiveModule();
  });

  it('should create an instance', () => {
    expect(containerDirectiveModule).toBeTruthy();
  });
});
