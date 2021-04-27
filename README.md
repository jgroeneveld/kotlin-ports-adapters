# kotlin ports / adapters

A super simple example to illustrate how to use the adapter pattern as application architecture in kotlin + spring boot.

## packages

- **adapters** defines all points to the outer world (datasources, apis, commands...)
- **domain** defines the logic itself. models can be top level model package for the whole domain or module level packages to be more specific when its localized. also defines interfaces it uses that will be fulfilled by adapter components.


In our case, adapters contains `api` and `db`,

## Follow the path

- Start with api/ArticlesController.
    - It is our adapter for our own api. The Controller needs a ArticleService defined in the domain. This is our entry point into the domain.
    - The controller is responsible to map between request/responses and the domain model. Details of the API should not leak into the domain. 
- We are now in the domain.
    - The ArticleService defines its needed dependencies via interfaces that are part of the domain.
    - The domain does not "know" what will provide these dependencies, it only knows about the interfaces.
    - The Service needs a `ArticleWriteRepository` (see [ISP](https://en.wikipedia.org/wiki/Interface_segregation_principle))
    - The Interface is implemented in one Adapter. In this case the `db` adapter. We leave the domain and see the implementation there.