describe('Jobs', () => {

  before(() => {
    cy.visit('http://localhost:8080')
    
    // delete all jobs
    cy.request('DELETE', 'http://localhost:8080/api/job')

    // wait for 1 second
    cy.wait(1000)
  })

  it('visit jobs page', () => {
    cy.get('a[href="#/jobs"]').click()

    cy.location('hash').should('include', 'jobs')
  })

  it('jobs are created', () => {

    // create first job
    cy.get('#description').clear().type('Implement main-class')
    cy.get('#type').select('IMPLEMENT')
    cy.get('#earnings').clear().type('150')
    cy.contains('Submit').click()

    // create second job
    cy.get('#description').clear().type('Test getAllJobs Endpoint')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('100')
    cy.contains('Submit').click()

    // create third job
    cy.get('#description').clear().type('Set up Frontend with Svelte')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('140')
    cy.contains('Submit').click()

    // table should now have 3 elements
    cy.get('tbody>tr').should('have.length', 3)

  })

  it('second page', () => {

    // create fourth job
    cy.get('#description').clear().type('create more tasks')
    cy.get('#type').select('IMPLEMENT')
    cy.get('#earnings').clear().type('110')
    cy.contains('Submit').click()

    // create fifth job
    cy.get('#description').clear().type('test everything')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('90')
    cy.contains('Submit').click()

    // table (first page) should now have 4 elements
    cy.get('tbody>tr').should('have.length', 4)

    // go to second page
    cy.contains('.page-link','2').click()

    // second page should have one element and its content should be 'test everything'
    cy.get('tbody>tr').should('have.length', 1)
    cy.get('tr>td:first-child').should('contain', 'test everything')
  })


})