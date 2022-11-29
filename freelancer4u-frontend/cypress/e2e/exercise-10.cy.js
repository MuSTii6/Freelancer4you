describe('Jobs', () => {

  before(() => {
    cy.visit('http://localhost:8080')
    
    cy.request('DELETE', 'http://localhost:8080/api/job')

    cy.wait(1000)
  })

  it('visit jobs page', () => {
    cy.get('a[href="#/jobs"]').click()

    cy.location('hash').should('include', 'jobs')
  })

  it('jobs are created', () => {

    cy.get('#description').clear().type('Implement main-class')
    cy.get('#type').select('IMPLEMENT')
    cy.get('#earnings').clear().type('150')
    cy.contains('Submit').click()

    cy.get('#description').clear().type('Test getAllJobs Endpoint')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('100')
    cy.contains('Submit').click()

    cy.get('#description').clear().type('Set up Frontend with Svelte')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('140')
    cy.contains('Submit').click()

    cy.get('tbody>tr').should('have.length', 3)

  })

  it('second page', () => {

    cy.get('#description').clear().type('create more tasks')
    cy.get('#type').select('IMPLEMENT')
    cy.get('#earnings').clear().type('110')
    cy.contains('Submit').click()

    cy.get('#description').clear().type('test everything')
    cy.get('#type').select('TEST')
    cy.get('#earnings').clear().type('90')
    cy.contains('Submit').click()

    cy.get('tbody>tr').should('have.length', 4)

    cy.contains('.page-link','2').click()

    cy.get('tbody>tr').should('have.length', 1)
    cy.get('tr>td:first-child').should('contain', 'test everything')
  })


})