import { PageSurroundModule } from './page-surround.module';

describe('PageSurroundModule', () => {
  let pageSurroundModule: PageSurroundModule;

  beforeEach(() => {
    pageSurroundModule = new PageSurroundModule();
  });

  it('should create an instance', () => {
    expect(pageSurroundModule).toBeTruthy();
  });
});
